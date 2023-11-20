package symmetrical.cosmic.chemistry.diatomics

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class KeyValue(
    private val fermion: IFermion = Fermion()
) : Diatomic(),
    IFermion by fermion
{

    object Static {
        const val KEY       : Int = Diatomic.Static.LAST+1
        const val VALUE     : Int = Diatomic.Static.LAST+2

        const val LAST      : Int = VALUE
    }
    constructor() : this(Fermion()) {
    }
    constructor(key: Atom, value:Atom) : this(){
        add(key)
        add(value)
        val size = size();
    }

    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(KeyValue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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