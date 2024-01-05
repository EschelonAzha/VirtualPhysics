package applications.tests.dictionary

import symmetrical.cosmic._physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom

class City : symmetrical.cosmic.physics.atomic.atoms.Atom {
    constructor(content:String) {
        Quark.value(this).setWavelength(content)
    }
}