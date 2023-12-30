package asymmetrical.wormholes.pulsar.plugins.http.writers

import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

class SpinWriter : FundamentalPropertyWriter {
    constructor(outlet: IOutlet) : super(outlet) {
    }

    override fun write(atom: Atom) : SpinWriter {
        val quark = atom.nucleons.getProton(ValueProton::class).getValue() as Quark
     //   outlet.write(quark.momentum())
        outlet.write(momentum(quark))
    //    outlet.write(atom.quarkSpin())
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