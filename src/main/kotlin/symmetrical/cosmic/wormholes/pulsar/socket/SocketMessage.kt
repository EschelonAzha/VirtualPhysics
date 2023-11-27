package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class SocketMessage(
    private val antiMatter: IAntiMatter = AntiMatter(SocketMessage::class),
) : Compound(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(SocketMessage::class),
    ) {
        bytes = ByteArray(0)
    }

    object Static {
        const val LAST = Compound.Static.LAST
    }

    private lateinit var bytes:ByteArray


    constructor(bytes:ByteArray) : this() {
        this.bytes = bytes
    }


    fun getByteArray() : ByteArray {
        return bytes
    }

    fun getString() : String {
        return bytes.toString()
    }
}