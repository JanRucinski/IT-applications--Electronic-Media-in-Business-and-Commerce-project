import { Link } from 'react-router-dom';

import { Button } from '../ui/button';
import { heroSection } from '@/config/content';

const HeroSection = () => {
  return (
    <div className="flex justify-between space-x-14 items-center">
      <div className="flex-1 min-w-[45%]">
        <h1 className="text-5xl font-bold text-sky-950">{heroSection.title}</h1>
        <p className="my-5 text-lg text-slate-700">{heroSection.description}</p>
        <div className="flex space-x-2 my-3">
          <Button asChild size="lg" className="text-lg">
            <Link to={heroSection.ctaButtons[0].to}>
              {heroSection.ctaButtons[0].title}
            </Link>
          </Button>
          <Button asChild variant="outline" size="lg" className="text-lg">
            <Link to={heroSection.ctaButtons[1].to}>
              {heroSection.ctaButtons[1].title}
            </Link>
          </Button>
        </div>
      </div>
      <div>
        <img
          src={heroSection.image}
          alt={heroSection.title}
          className="overflow-hidden rounded-3xl shadow-lg"
        />
      </div>
    </div>
  );
};

export default HeroSection;
