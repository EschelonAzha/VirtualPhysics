package symmetrical.cosmic._physics.atomic.atoms.states.bytes

import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton

class QByte(
    private val matter: IMatter = Matter(QByte::class, QByte::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(QByte::class, QByte::class),
    ) init {
        setByte(" ".toByte())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun setByte(value:Byte) : QByte {
        Quark.value(this).setWavelength(value)
        return this
    }
}