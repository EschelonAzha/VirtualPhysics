package symmetrical.cosmic.chemistry.diatomics

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class KeyValue(
    private val antiMatter: IAntiMatter = AntiMatter(KeyValue::class, KeyValue::class),
) : Diatomic(),
    IAntiMatter by antiMatter
{

    object Static {
        const val KEY       : Int = Diatomic.Static.LAST+1
        const val VALUE     : Int = Diatomic.Static.LAST+2

        const val LAST      : Int = VALUE
    }
    constructor() : this(
        AntiMatter(KeyValue::class, KeyValue::class),
    )
    constructor(key: Atom, value:Atom) : this(){
        add(key)
        add(value)
        val size = size();
    }


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
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