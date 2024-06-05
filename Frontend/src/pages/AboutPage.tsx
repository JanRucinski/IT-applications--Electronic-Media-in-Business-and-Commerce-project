import Faq from '@/components/about/FAQ';
import { aboutSection } from '@/config/content';

const AboutPage = () => {
  return (
    <section className="container flex-1 flex flex-col-reverse md:grid md:grid-cols-2 items-center justify-between gap-20 py-4 md:py-10">
      <div className="flex flex-col justify-between px-5 py-2 md:px-8 md:py-5 rounded-md shadow-md w-full">
        <div>
          <h1 className="text-center font-semibold text-xl mb-3 md:text-3xl md:mb-4">
            Frequently Asked Questions
          </h1>
        </div>
        <Faq />
      </div>
      <div>
        <h1 className="text-center font-bold text-2xl md:text-4xl mb-3">
          {aboutSection.title}
        </h1>
        <p className="text-lg leading-relaxed mb-6">
          {aboutSection.description}
        </p>
        <div className="h-60 md:h-72 rounded-md overflow-hidden shadow-md border py-2">
          <img
            src={aboutSection.image}
            alt={aboutSection.imgAlt}
            className="w-full h-full object-cover"
          />
        </div>
      </div>
    </section>
  );
};

export default AboutPage;
