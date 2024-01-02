package applications.tests.dictionary

import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom

class State : Atom {
    constructor(content:String) {
        Quark.value(this).setWavelength(content)
    }
}