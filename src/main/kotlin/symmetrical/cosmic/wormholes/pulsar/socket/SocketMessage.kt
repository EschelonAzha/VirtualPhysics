package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class SocketMessage(
    private val luminescent: ILuminescent = Luminescent(SocketMessage::class),
) : Compound(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(SocketMessage::class),
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