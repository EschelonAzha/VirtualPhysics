package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down

class Capacitor : Atom() {

    fun with(content:String) : Capacitor {
        super.with(content)
        return this
    }

    override fun capacitanceChange(me: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return zBoson
    }
}