package asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses

import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.FileServer
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.Success
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics._subatomic.matter.colors.manifestations.CRLFTerminatedColor
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.CRLFTerminatedSpin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

class JSWriter : FileServer {
    constructor(outlet: IOutlet) : super(outlet) {
    }
    override fun run() : Boolean {
        val filePath:String = (path.get(0) as QString).quarkValueStr()
        val lines: Compound = loadFile(QString(filePath))
        lines.applyQuarkSpin(CRLFTerminatedSpin())
        lines.applyElectronSpin(CRLFTerminatedSpin())

        writeResponse(Success(lines))
        println("JS Script Written")
        return true  // close this socket
    }
}