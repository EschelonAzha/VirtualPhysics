package asymmetrical.wormholes.pulsar.plugins.http.writers

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

class SpinWriter : FundamentalPropertyWriter {
    constructor(outlet: IOutlet) : super(outlet) {
    }

    override fun write(atom: Atom) : SpinWriter {
        outlet.write(Wavelength.format(atom))
        return this;
    }

}