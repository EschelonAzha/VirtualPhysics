package asymmetrical.wormholes.pulsar.plugins

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.IBeam
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage


open class Task(private val particle: Particle = Particle()) : IParticle by particle {
    protected lateinit var message   : SocketMessage
    protected lateinit var outlet    : IOutlet
    private            var payload   : IBeam = Beam(0)


    constructor(outlet: IOutlet) : this(Particle()) {
        this.outlet     = outlet
    }

    open fun run() : Boolean {
        return false
    }
    fun getPayload() : IBeam {
        return payload
    }
    open fun setMessage(message: SocketMessage) : Task {
        this.message = message
        return this
    }
    fun setPayload(payload:Molecule) : Task {
        this.payload = payload;
        return this
    }


}