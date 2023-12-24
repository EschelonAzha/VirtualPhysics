package asymmetrical.wormholes.pulsar.plugins.http


import asymmetrical.wormholes.pulsar.plugins.Inspector
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.HttpMessage
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.RequestMethod
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.wormholes.pulsar.dictionary.Path
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

open class HttpInspector : Inspector {

    private   lateinit var requestMethod : RequestMethod
    protected lateinit var method        : QString
    protected lateinit var path          : Path

    constructor() : super(){

    }
    override fun inspect() : Int {
        return 0
    }
    override fun setMessage(message: SocketMessage) : Inspector {
        super.setMessage(message)
        requestMethod   = (message as HttpMessage).getRequestMethod()
        method          = requestMethod.getRequestMethod()
        path            = message.getRequestMethod().getPath()
        return this
    }
}