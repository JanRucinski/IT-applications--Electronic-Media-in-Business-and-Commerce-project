export const heroSection = {
  title: 'Welcome to our store',
  description:
    'Discover top-quality bikes, premium parts, and convenient rentals. Your adventure starts here with expert advice and exceptional service. Join our biking community today!',
  image: './images/hero1.webp',
  imgAlt: 'Hero section',
  ctaButtons: [
    {
      title: 'Explore available models',
      to: '/bikes',
    },
    {
      title: 'Sign-in',
      to: '/login',
    },
  ],
};

export const aboutSection: {
  title: string;
  description: string;
  image: string;
  imgAlt: string;
  faq: { question: string; answer: string }[];
} = {
  title: 'Our Story',
  description:
    'At BikeShop, we are passionate about all things cycling. Located in the heart of Wrocław, we offer top-quality bikes, premium parts, and expert repairs. Whether you’re looking to buy, rent, or get your bike serviced, our friendly team is here to help you enjoy the ride.',
  image: './images/3p.webp',
  imgAlt: 'Bike Shop Image',
  faq: [
    {
      question: 'How can I place an order?',
      answer:
        'You can easily place an order on our website by browsing our product catalog, selecting the items you want, and adding them to your cart. Then, proceed to checkout, where you can provide your shipping and payment information to complete the order.',
    },
    {
      question: 'What payment methods do you accept?',
      answer:
        'We accept various payment methods, including credit cards, debit cards, net banking, and mobile wallet payments. You can choose the payment option that is most convenient for you during the checkout process.',
    },
    {
      question: 'How long does shipping take?',
      answer:
        'Shipping times may vary depending on your location and the shipping method chosen. Typically, orders are processed within 1-2 business days, and delivery can take 3-7 business days within India. You will receive a tracking notification once your order is shipped.',
    },
    {
      question: "Can I return a product if I'm not satisfied?",
      answer:
        'Yes, we have a hassle-free return policy. If you are not satisfied with your purchase, you can initiate a return within 30 days of receiving the product. Please contact our customer support at example@gmail.com for assistance.',
    },
    {
      question: 'Do you offer international shipping?',
      answer:
        'Yes, we offer international shipping to select countries. Shipping rates and delivery times may vary depending on the destination. You can check if we ship to your country during the checkout process.',
    },
    {
      question: 'What is the return period for the product?',
      answer:
        'You have 30 days from the date of receipt to return the product. For a smooth return process, please ensure the product is in its original condition, complete with all tags and packaging.',
    },
  ],
};
