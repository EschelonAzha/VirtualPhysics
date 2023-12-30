package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors



import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.HttpMessage
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.ConnectionType
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.Upgrade
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.WebSocketKey
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic.dictionary.protons.ValueProton

class WebSocketUpgrade : HttpInspector {
    constructor() : super() {
    }
    override fun inspect() : Int {
        if (method.getProton(ValueProton::class).getValue().wavelength().toString().lowercase() != "get")
            return 0
        getPayload().add("")
        val file = (path.get(0) as QString).getProton(ValueProton::class).getValue().wavelength().toString()
        if (!(file.endsWith("wormhole")))
            return 0

        if (isWebSocketUpgrade())
            return 1
        return 0
    }
    private fun getHttpMessage() : HttpMessage {
        return message as HttpMessage
    }
    private fun getLowerCase(value: KeyValue) : String {
        return value.getValue()!!.getProton(ValueProton::class).getValue().wavelength().toString().lowercase()
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
}