package symmetrical.cosmic._physics.atomic.atoms

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.color.IColorCharge
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.IOrbitals

interface IAtom : Element, IEmitter, IOrbitals, INucleons, IParticle, IColorCharge {
}