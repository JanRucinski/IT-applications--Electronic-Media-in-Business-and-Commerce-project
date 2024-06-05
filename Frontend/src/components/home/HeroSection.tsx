import { Link } from 'react-router-dom';

import { Button } from '../ui/button';
import { heroSection } from '@/config/content';

const HeroSection = () => {
  return (
    <div className="flex flex-col md:flex-row justify-between md:space-x-14 items-center gap-4">
      <div className="md:flex-1 min-w-full md:min-w-[45%]">
        <h1 className="text-3xl md:text-5xl font-bold text-sky-950">
          {heroSection.title}
        </h1>
        <p className="my-2 md:my-5 text-base md:text-lg text-slate-700">
          {heroSection.description}
        </p>
        <div className="flex flex-col md:flex-row gap-2 md:gap-3 my-3">
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
          className="overflow-hidden rounded-3xl shadow-md md:shadow-lg mb-4 md:mb-0"
        />
      </div>
    </div>
  );
};

export default HeroSection;
