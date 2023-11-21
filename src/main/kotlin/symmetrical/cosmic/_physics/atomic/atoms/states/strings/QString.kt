package symmetrical.cosmic._physics.atomic.atoms.states.strings

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class QString(
    private val fermion: IFermion = Fermion(QString::class),
) : Atom(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(QString::class),
    )   init {
        setString("")
    }

    constructor(value:String) : this() {
        setString(value)
    }


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon)
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun red() : String {
        return nucleons.getValueProton().red() as String
    }
    fun setString(value:String) : QString {

        setQuarkValue(value)
        return this
    }
}