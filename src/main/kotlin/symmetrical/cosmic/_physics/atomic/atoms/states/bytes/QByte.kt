package symmetrical.cosmic._physics.atomic.atoms.states.bytes

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class QByte(
    private val fermion: Luminescent = Luminescent(QByte::class),
) : Atom(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(QByte::class),
    ) init {
        setByte(" ".toByte())
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun red() : Byte {
        return nucleons.getValueProton().red() as Byte
    }
    fun setByte(value:Byte) : QByte {
        setQuarkValue(value)
        return this
    }
}