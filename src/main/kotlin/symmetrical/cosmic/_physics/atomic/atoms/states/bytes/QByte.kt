package symmetrical.cosmic._physics.atomic.atoms.states.bytes

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class QByte(
    private val antiMatter: AntiMatter = AntiMatter(QByte::class, QByte::class),
) : Atom(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(QByte::class, QByte::class),
    ) init {
        setByte(" ".toByte())
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun red() : Byte {
        return nucleons.getValueProton().red() as Byte
    }
    fun setByte(value:Byte) : QByte {
        setQuarkValue(value)
        return this
    }
}