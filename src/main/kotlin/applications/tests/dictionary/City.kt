package applications.tests.dictionary

import symmetrical.cosmic._physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom

class City : Atom {
    constructor(content:String) {
        Quark.value(this).setWavelength(content)
    }
}