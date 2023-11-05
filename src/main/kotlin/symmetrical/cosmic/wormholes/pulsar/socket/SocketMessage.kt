package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

open class SocketMessage : Compound {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val LAST = Compound.Static.LAST
    }

    private val bytes:ByteArray

    constructor() {
        bytes = ByteArray(0)
    }
    constructor(bytes:ByteArray) {
        this.bytes = bytes
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
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