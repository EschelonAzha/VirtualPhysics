package symmetrical.physics.atomic.bonds.covalent
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.fundamentals.angular_momentum.AngularMomentum
import symmetrical.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.spacial.IParticleBeam
import symmetrical.physics.subatomic.spacial.ParticleBeam
import symmetrical.physics.atomic.atoms.states.strings.QString
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter


// For more information visit:  https://en.wikipedia.org/wiki/Molecule

open class Molecular(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(Molecular::class),
    private var _particleBeam   : ParticleBeam = ParticleBeam(),

    ) : Atom(),
    IMatterAntiMatter by matterAntiMatter,
    IParticleBeam by _particleBeam,
    IParticle
{

    open fun capacity(initialCapacity:Int) : Molecular {
        _particleBeam.capacity(initialCapacity)
        return this
    }

    object Static {
        const val LAST      : Int = -1
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);
        clear();
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        remainder = this._particleBeam.absorb(remainder)
        shrink()
        return remainder
    }

    fun applyQuarkMomentum(momentum: AngularMomentum) : Molecular {
        for (i in 0 until size()) {
            val atom: Atom = get(i) as Atom
            Quark.value(this).setAngularMomentum(momentum)
        }
        return this
    }
    fun applyQuarkSpin(spin: Any?) : Molecular {
        for (i in 0 until size()) {
            val atom: Atom = get(i) as Atom
            Quark.value(this).getSpin().setContent(spin)
        }
        return this
    }
    fun applyElectronSpin(spin: Spin) : Molecular {
        for (i in 0 until size()) {
            val atom : Atom = get(i) as Atom
            atom.setElectronSpin(spin)
        }
        return this
    }
    override fun betaMinusDecay() : Atom {
        for (i in 0 until size()) {
            val atom: Atom = get(i) as Atom
            atom.betaMinusDecay()
        }
        return this
    }
    override fun betaPlusDecay() : Atom {
        for (i in 0 until size()) {
            val atom: Atom = get(i) as Atom
            atom.betaPlusDecay()
        }
        return this
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }


    open fun getAtom(pos:Int) : Atom {
        return get(pos) as Atom
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }


    fun materialize(strings:List<String>) : Molecular {
        for (item in strings) {
            add(QString().with(item))
        }
        shrink()
        return this
    }
    private fun radiate() : String {
        val classId = matterAntiMatter.getClassId()
        val atom = super.emit().radiate()
        val beam = _particleBeam.emit().radiate()
        return classId+atom+beam

    }
}