package asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses

import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.FileServer
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.Success
import symmetrical.cosmic.dictionary.formats.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.dictionary.protons.ValueProton

class JSWriter : FileServer {
    constructor(outlet: IOutlet) : super(outlet) {
    }
    private fun runx() : Boolean {
        val filePath:String = (path.get(0) as QString).getProton(ValueProton::class).getValue().wavelength().toString()
        val lines: Compound = loadFile(QString(filePath))
        lines.applyQuarkMomentum(CRLFTerminatedMomentum())
        lines.applyQuarkSpin(Spin())

        writeResponse(Success(lines))
        println("JS Script Written")
        return true  // close this socket
    }
    override fun run() : Boolean {
        val qString     : QString = path.get(0) as QString
        val proton      : Proton  = qString.getProton(ValueProton::class)
        val quark       : Quark   = proton.getValue()
        val filePath    : String  = quark.wavelength().toString()

        val lines: Compound = loadFile(QString(filePath))
        lines.applyQuarkMomentum(CRLFTerminatedMomentum())
        lines.applyQuarkSpin(Spin())

        writeResponse(Success(lines))
        println("JS Script Written")
        return true  // close this socket
    }
}