package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom

class State : Atom {
    constructor(content:String) {
        Quark.value(this).setWavelength(content)
    }
}