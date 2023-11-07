package asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses


import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.FileServer
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.Success
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

class LoadHomePage : FileServer {
    constructor(outlet: IOutlet) : super(outlet) {

    }
    override fun run() : Boolean {
        val lines: Compound = loadFile(QString("index.html"))

    //    lines.applyElectronSpin(CRLFTerminatedSpin())

        writeResponse(Success(lines))
        println("Home Page Written")
        return true  // close this socket
    }
}