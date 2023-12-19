package symmetrical.cosmic._physics.atomic.atoms.states.bytes

import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom

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
    override fun red() : Byte {
        return nucleons.getValueProton().red() as Byte
    }
    fun setByte(value:Byte) : QByte {
        setQuarkValue(value)
        return this
    }
}