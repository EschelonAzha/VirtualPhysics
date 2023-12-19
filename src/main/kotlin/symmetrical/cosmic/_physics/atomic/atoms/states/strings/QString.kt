package symmetrical.cosmic._physics.atomic.atoms.states.strings

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom


open class QString(
    private val matter: IMatter = Matter(QString::class, QString::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(QString::class, QString::class),
    )   init {
        setString("")
    }

    constructor(value:String) : this() {
        setString(value)
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon)
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
    override fun red() : String {
        return nucleons.getValueProton().red() as String
    }
    fun setString(value:String) : QString {

        setQuarkValue(value)
        return this
    }
}