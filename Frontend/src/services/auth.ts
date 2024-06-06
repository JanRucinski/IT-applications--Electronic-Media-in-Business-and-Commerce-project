import { LoginSchemaType, SignUpSchemaType } from '@/schemas/auth-schema';
import axiosInstance from '@/lib/axios-instance';

const AUTH_URL = '/auth';

export const login = async (data: LoginSchemaType) => {
  const response = await axiosInstance.post(`${AUTH_URL}/login`, data);
  return response.data;
};

export const signUp = async (data: SignUpSchemaType) => {
  const response = await axiosInstance.post(`${AUTH_URL}/register`, data);
  return response.data;
};
