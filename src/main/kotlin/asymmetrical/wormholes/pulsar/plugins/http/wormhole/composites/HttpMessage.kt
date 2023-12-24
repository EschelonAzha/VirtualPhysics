package asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites


import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.ConnectionType
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.RequestMethod
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.Upgrade
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.WebSocketKey
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.wormholes.pulsar.dictionary.Host
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

class HttpMessage : SocketMessage {
    object Static {
        var REQUEST_METHOD      = 0  // <-- These are dynamically updated
        var HOST                = 0  // <-- These are dynamically updated
        var UPGRADE             = 0  // <-- These are dynamically updated
        var WEB_SOCKET_KEY      = 0  // <-- These are dynamically updated
        var CONNECTION          = 0  // <-- These are dynamically updated

        var LAST                = 0  // <-- These are dynamically updated
    }

    private var tokens :List<String>
    constructor(bytes:ByteArray) : super(bytes) {
        this.tokens  = String(bytes).split("\r\n")
        this.tokens  = truncate(this.tokens)
        createElements()
    }
    fun getConnection() : ConnectionType {
        return get(Static.CONNECTION) as ConnectionType
    }
    fun getHost() : Host {
        return get(Static.HOST) as Host
    }
    fun getRequestMethod() : RequestMethod {
        var result = get(Static.REQUEST_METHOD)
        return result as RequestMethod
    }
    fun getUpgrade() : Upgrade {
        var result = get(Static.UPGRADE)
        return result as Upgrade
    }
    fun getWebSocketKey() : WebSocketKey {
        return get(Static.WEB_SOCKET_KEY) as WebSocketKey
    }


    private fun createElements() : Unit {
        for (i in tokens.indices ) {
            val value = tokens[i]
            if (value.lowercase().contains("get")) {
                Static.REQUEST_METHOD = nextPosition()
                add(RequestMethod(value))
                continue
            }
            if (value.lowercase().startsWith("host")) {
                var tokens = value.split(" ")
                Static.HOST = nextPosition()
                val key = Strings.removeCharacter(":"[0],tokens[0])
                add(Host(QString(key), QString(tokens[1])))
                continue
            }
            if (value.lowercase().startsWith("upgrade")) {
                var tokens = value.split(" ")
                Static.UPGRADE = nextPosition()
                val key = Strings.removeCharacter(":"[0],tokens[0])
                add(Upgrade(QString(key), QString(tokens[1])))
                continue
            }
            if (value.lowercase().startsWith("sec-websocket-key")) {
                var tokens = value.split(" ")
                Static.WEB_SOCKET_KEY = nextPosition()
                val key = Strings.removeCharacter(":"[0],tokens[0])
                add(WebSocketKey(QString(key), QString(tokens[1])))
                continue
            }
            if (value.lowercase().startsWith("connection")) {
                var tokens = value.split(" ")
                Static.CONNECTION = nextPosition()
                val key = Strings.removeCharacter(":"[0],tokens[0])
                add(ConnectionType(QString(key), QString(tokens[1])))
                continue
            }
            add(QString(tokens[i]))
        }
        shrink()
        Static.LAST = nextPosition() -1
        tokens = ArrayList<String>(0)
    }

    private fun nextPosition() : Int {
        return size()  + (SocketMessage.Static.LAST+1)
    }

    private fun truncate(tokens:List<String>) : List<String> {
        var last = tokens[tokens.size-1]
        var result:MutableList<String> = tokens as MutableList<String>
        if (last == "\r") {
            result = tokens as MutableList<String>
            result.removeAt(tokens.size-1)
        }
        return result
    }
}