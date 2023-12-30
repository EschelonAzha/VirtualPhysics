package asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses


import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.FileServer
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.ConnectionType
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.Upgrade
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.WebSocketKey
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.WebSocketSwitchProtocol
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import asymmetrical.wormholes.pulsar.plugins.http.writers.SpinWriter
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.dictionary.protons.ValueProton
import java.security.MessageDigest
import java.util.*

class UpgradeWebSocket : FileServer {
    private lateinit var connection      : ConnectionType
    private lateinit var key             : WebSocketKey
    private lateinit var upgrade         : Upgrade


    constructor(outlet: IOutlet) : super(outlet) {
    }
    override fun run() : Boolean {
        upgrade     = getHttpMessage().getUpgrade()
        key         = getHttpMessage().getWebSocketKey()
        connection  = getHttpMessage().getConnection()
        webSocketUpgrade();
        return false   // Don't close this socket
    }
    private fun generateWebSocketAcceptKey(key: String): String {
        val hashDigest = MessageDigest.getInstance("SHA-1").digest(
            (key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").toByteArray()
        )
        return Base64.getEncoder().encodeToString(hashDigest)
    }
    private fun webSocketUpgrade() : Boolean {
        var response: Compound = WebSocketSwitchProtocol(generateWebSocketAcceptKey(key.getValue()!!.getProton(
            ValueProton::class).getValue().wavelength().toString()))
        SpinWriter(outlet).write(response)
        outlet.flush()

        println("Upgrade Written")
        return false
    }

}