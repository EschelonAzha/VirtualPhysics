package symmetrical.cosmic.physics.atomic.atoms.states.strings

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark


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
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun setString(value:String) : QString {

        Quark.value(this).setWavelength(value)
        return this
    }
    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}