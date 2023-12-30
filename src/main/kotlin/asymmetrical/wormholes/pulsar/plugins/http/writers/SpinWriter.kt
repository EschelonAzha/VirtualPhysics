package asymmetrical.wormholes.pulsar.plugins.http.writers

import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

class SpinWriter : FundamentalPropertyWriter {
    constructor(outlet: IOutlet) : super(outlet) {
    }

    override fun write(atom: Atom) : SpinWriter {
        val proton = atom.getProton(ValueProton::class)
        val quark = proton.getValue() as Quark
        outlet.write(momentum(quark))
        return this;
    }

    private fun momentum(quark:Quark) : String {
        if (spin(quark))
            return quark.getAngularMomentum().format(quark.getWavelength().getQuantumField())
        else return quark.getWavelength().toString()
    }

    private fun spin(quark:Quark) : Boolean {
        return quark.getSpin().isPlus()
    }
}