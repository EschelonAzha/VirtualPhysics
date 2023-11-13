package symmetrical.cosmic._physics.atomic.atoms

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.color.IColorCharges
import symmetrical.cosmic._physics._subatomic.balanced.quarks.IQuarkValue
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.IOrbitals

interface IAtom : Element, Emitter, IOrbitals, INucleons, IParticle, IColorCharges, IQuarkValue {
}