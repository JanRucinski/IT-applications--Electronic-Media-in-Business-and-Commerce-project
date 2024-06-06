import { Link, useNavigate, useSearchParams } from 'react-router-dom';
import { zodResolver } from '@hookform/resolvers/zod';
import { useForm } from 'react-hook-form';
import { toast } from 'sonner';

import { Button } from '@/components/ui/button';
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from '@/components/ui/form';
import { LoginSchemaType, loginSchema } from '@/schemas/auth-schema';
import Spinner from '../shared/Spinner';
import { login } from '@/services/auth';
import { useAuth } from '@/store/user';
import { useEffect } from 'react';

export function LoginForm() {
  const form = useForm<LoginSchemaType>({
    resolver: zodResolver(loginSchema),
    mode: 'all',
    defaultValues: {
      username: '',
      password: '',
    },
  });

  const navigate = useNavigate();
  const [params] = useSearchParams();
  const checkout = params.get('checkout');
  const action = params.get('action');

  const { setUser, user } = useAuth();

  useEffect(() => {
    if (user) {
      if (checkout) {
        return navigate(`/checkout?action=${action}`);
      }
      navigate(user.role === 'admin' ? '/dashboard' : '/bikes');
    }
  }, [user, navigate, checkout, action]);

  const onSubmit = async (values: LoginSchemaType) => {
    try {
      const response = await login(values);
      const isAdmin = response.isAdmin;
      setUser({
        email: response.user,
        token: response.token,
        fullName: response.fullName,
        role: isAdmin ? 'admin' : 'user',
      });
    } catch (error) {
      toast.error('Login failed. Please try again.');
    }
  };

  return (
    <Card className="mx-auto max-w-md">
      <CardHeader>
        <CardTitle className="text-2xl">Login</CardTitle>
        <CardDescription>
          Enter your login below to login to your account
        </CardDescription>
      </CardHeader>
      <CardContent>
        <Form {...form}>
          <form className="space-y-6" onSubmit={form.handleSubmit(onSubmit)}>
            <FormField
              control={form.control}
              name="username"
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Username</FormLabel>
                  <FormControl>
                    <Input {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />
            <FormField
              control={form.control}
              name="password"
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Password</FormLabel>
                  <FormControl>
                    <Input {...field} type="password" />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />
            <Button
              type="submit"
              disabled={form.formState.isSubmitting}
              className="disabled:none w-full"
            >
              {form.formState.isSubmitting ? (
                <div className="flex-center gap-2">
                  <Spinner />
                </div>
              ) : (
                'Login'
              )}
            </Button>
          </form>
        </Form>
        <div className="mt-4 text-center text-sm">
          Don&apos;t have an account?{' '}
          <Link to="/sign-up" className="underline">
            Sign up
          </Link>
        </div>
      </CardContent>
    </Card>
  );
}
