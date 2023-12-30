package asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses

import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.FileServer
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.Success
import symmetrical.cosmic.dictionary.formats.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.dictionary.protons.ValueProton

class JSWriter : FileServer {
    constructor(outlet: IOutlet) : super(outlet) {
    }

    override fun run() : Boolean {
        val atom        : QString = path.get(0) as QString
        val filePath    : String  = Wavelength.field(atom).toString()

        val lines: Compound = loadFile(QString(filePath))
        lines.applyQuarkMomentum(CRLFTerminatedMomentum())
        lines.applyQuarkSpin(Spin())

        writeResponse(Success(lines))
        println("JS Script Written")
        return true  // close this socket
    }
}