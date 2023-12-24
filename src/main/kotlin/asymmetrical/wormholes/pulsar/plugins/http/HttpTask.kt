package asymmetrical.wormholes.pulsar.plugins.http


import asymmetrical.wormholes.pulsar.plugins.Task
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.HttpMessage
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields.RequestMethod
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.wormholes.pulsar.dictionary.Path
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

open class HttpTask : Task {


    protected lateinit var method        : QString
    protected lateinit var path          : Path
    protected lateinit var requestMethod : RequestMethod

    constructor(outlet: IOutlet) : super(outlet) {
    }
    public fun getHttpMessage() : HttpMessage {
        return message as HttpMessage
    }
    override fun run() : Boolean {
        return false
    }
    override fun setMessage(message: SocketMessage): Task {
        super.setMessage(message)
        requestMethod   = (message as HttpMessage).getRequestMethod()
        method          = requestMethod.getRequestMethod()
        path            = message.getRequestMethod().getPath()
        return this
    }
}