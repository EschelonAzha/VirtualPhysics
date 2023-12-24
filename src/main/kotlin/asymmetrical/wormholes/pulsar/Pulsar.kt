package asymmetrical.wormholes.pulsar

import asymmetrical.machine.threads.Energy
import asymmetrical.wormholes.pulsar.sockets.ServerOutlet
import symmetrical.cosmic.cosmology.INebula
import java.net.ServerSocket
import java.net.Socket
import kotlin.reflect.KClass

open class Pulsar : Energy {
    private val galaxy:Galaxy
    private val nebula :KClass<INebula>
    private var port = 0;
    private var server: ServerSocket

    constructor(galaxy:Galaxy, port:Int, INebula: KClass<INebula>) {
        this.galaxy = galaxy
        galaxy.start()
        this.port   = port
        this.nebula = INebula
        this.server = ServerSocket(port)
    }

    override fun run() {
        while (true) {
            val socket: Socket = server.accept()
            Multiplexer(galaxy, ServerOutlet(socket), nebula).start()
        }
    }
}