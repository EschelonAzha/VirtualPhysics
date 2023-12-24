package asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites


import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

open class ResponseMessage : Compound {
    private var returnCode    = "200"
    private var returnMessage = "OK"
    constructor(returnCode:String, returnMessage:String) {
        this.returnCode = returnCode
        this.returnMessage = returnMessage
        add(CrLfTerminatedString("HTTP/1.1 $returnCode $returnMessage"))
        add(CrLfTerminatedString("Server: Pulsar 1.0"))
        add(CrLfTerminatedString("Content-Type: text/html; charset=UTF-8"))
        add(CrLfTerminatedString(""))
    }
}