package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors



import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.HttpMessage
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.ConnectionType
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.Upgrade
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.WebSocketKey
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue

class WebSocketUpgrade : HttpInspector {
    constructor() : super() {

    }

    override fun inspect() : Int {
        if (method.quarkValueStr().lowercase() != "get")
            return 0
        getPayload().add("")
        val file = (path.get(0) as QString).quarkValueStr()
        if (!(file.endsWith("wormhole")))
            return 0

        if (isWebSocketUpgrade())
            return 1
        return 0
    }
    private fun isWebSocketUpgrade() : Boolean {
        val upgrade         : Upgrade = getHttpMessage().getUpgrade()
        val key             : WebSocketKey = getHttpMessage().getWebSocketKey()
        val connection      : ConnectionType = getHttpMessage().getConnection()
        return isUpgradeToWebSocket(connection, upgrade)
    }
    private fun isUpgradeToWebSocket(connection: ConnectionType, upgrade: Upgrade) : Boolean {
        if (getLowerCase(connection) != "upgrade")
            return false
        return getLowerCase(upgrade) == "websocket"
    }
    private fun getLowerCase(value: KeyValue) : String {
        return value.getValue()!!.quarkValueStr().lowercase()
    }

    private fun getHttpMessage() : HttpMessage {
        return message as HttpMessage
    }
}