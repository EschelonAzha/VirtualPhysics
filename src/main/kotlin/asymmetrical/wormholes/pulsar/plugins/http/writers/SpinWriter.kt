package asymmetrical.wormholes.pulsar.plugins.http.writers

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

class SpinWriter : FundamentalPropertyWriter {
    constructor(outlet: IOutlet) : super(outlet) {
    }

    override fun write(atom: Atom) : SpinWriter {
        outlet.write(atom.quarkMomentum())
    //    outlet.write(atom.quarkSpin())
        return this;
    }
}