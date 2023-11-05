package asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites


import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

class WebSocketSwitchProtocol : Compound {
    private var returnCode    = "101"
    private var returnMessage = "Switching Protocols"
    constructor(acceptKey:String) {
        val rc  : String  = returnCode
        val msg : String  = returnMessage
        add(CrLfTerminatedString("HTTP/1.1 $rc $msg"))
        add(CrLfTerminatedString("Upgrade: websocket"))
        add(CrLfTerminatedString("Connection: Upgrade"))
        val print = "Sec-WebSocket-Accept: $acceptKey"
        println(print)
        add(CrLfTerminatedString("Sec-WebSocket-Accept: $acceptKey"))
//        add(CrLfTerminatedString("Sec-WebSocket-Protocol: chat"))
        add(CrLfTerminatedString(""))
        shrink()
    }
}