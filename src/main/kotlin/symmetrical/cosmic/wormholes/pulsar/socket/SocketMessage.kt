package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class SocketMessage(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Compound(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )  {
        bytes = ByteArray(0)
    }

    object Static {
        const val LAST = Compound.Static.LAST
    }

    private lateinit var bytes:ByteArray


    constructor(bytes:ByteArray) : this() {
        this.bytes = bytes
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(SocketMessage::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun getByteArray() : ByteArray {
        return bytes
    }

    fun getString() : String {
        return bytes.toString()
    }
}