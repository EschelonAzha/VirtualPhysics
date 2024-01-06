package symmetrical.cosmic.physics.atomic.atoms.states.bytes

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark

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