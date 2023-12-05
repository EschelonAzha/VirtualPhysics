package symmetrical.cosmic._physics.atomic.atoms.states.strings

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class QString(
    private val antiMatter: IAntiMatter = AntiMatter(QString::class, QString::class),
) : Atom(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(QString::class, QString::class),
    )   init {
        setString("")
    }

    constructor(value:String) : this() {
        setString(value)
    }


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon)
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
    override fun red() : String {
        return nucleons.getValueProton().red() as String
    }
    fun setString(value:String) : QString {

        setQuarkValue(value)
        return this
    }
}