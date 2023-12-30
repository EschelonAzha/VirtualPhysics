package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors



import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.HttpMessage
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.ConnectionType
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.Upgrade
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.WebSocketKey
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic.dictionary.protons.ValueProton

class WebSocketUpgrade : HttpInspector {
    constructor() : super() {
    }
    override fun inspect() : Int {
        if (Wavelength.field(method).toString().lowercase() != "get")
            return 0
        getPayload().add("")
        val atom = path.get(0) as QString
        val file = Wavelength.field(atom).toString()
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
        val atom: Atom = value.getValue() as Atom
        return Wavelength.field(atom).toString().lowercase()
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