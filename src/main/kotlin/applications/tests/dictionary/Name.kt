package applications.tests.dictionary

import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom

class Name : Atom {
    constructor(content:String) {
        Quark.value(this).setWavelength(content)
    }
}