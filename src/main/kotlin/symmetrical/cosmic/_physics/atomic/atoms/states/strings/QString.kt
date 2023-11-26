package symmetrical.cosmic._physics.atomic.atoms.states.strings

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class QString(
    private val luminescent: ILuminescent = Luminescent(QString::class),
) : Atom(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(QString::class),
    )   init {
        setString("")
    }

    constructor(value:String) : this() {
        setString(value)
    }


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon)
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun red() : String {
        return nucleons.getValueProton().red() as String
    }
    fun setString(value:String) : QString {

        setQuarkValue(value)
        return this
    }
}