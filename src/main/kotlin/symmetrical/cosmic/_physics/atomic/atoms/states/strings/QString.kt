package symmetrical.cosmic._physics.atomic.atoms.states.strings

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton


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
    override fun red() : String {
        return nucleons.getProton(ValueProton::class).red() as String
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