package symmetrical.cosmic.chemistry.diatomics

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom

open class KeyValue(
    private val matter: IMatter = Matter(KeyValue::class, KeyValue::class),
) : Diatomic(),
    IMatter by matter
{

    object Static {
        const val KEY       : Int = Diatomic.Static.LAST+1
        const val VALUE     : Int = Diatomic.Static.LAST+2

        const val LAST      : Int = VALUE
    }
    constructor() : this(
        Matter(KeyValue::class, KeyValue::class),
    )
    constructor(key: Atom, value:Atom) : this(){
        add(key)
        add(value)
        val size = size();
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

    fun getKey() : Atom? {
        if (size()>0)
            return get(Static.KEY) as Atom
        return null
    }
    fun getValue() : Atom? {
        if (size()>1)
            return get(Static.VALUE) as Atom
        return null
    }
}