package asymmetrical.wormholes.pulsar.plugins.http.writers

import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics.atomic.atoms.Atom

class SpinWriter : FundamentalPropertyWriter {
    constructor(outlet: IOutlet) : super(outlet) {
    }

    override fun write(atom: Atom) : SpinWriter {
        outlet.write(atom.quarkMomentum())
    //    outlet.write(atom.quarkSpin())
        return this;
    }
}