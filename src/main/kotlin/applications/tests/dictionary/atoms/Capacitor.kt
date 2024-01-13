package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down

class Capacitor : Atom {
    constructor() {

    }
    constructor(content:String) : super(content) {

    }
    override fun capacitanceChange(me: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return zBoson
    }
}