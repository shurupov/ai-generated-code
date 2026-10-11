import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import { describe, it, expect, beforeAll, afterAll, afterEach } from 'vitest';
import { setupServer } from 'msw/node';
import { http, HttpResponse } from 'msw';
import App from './App';

// Define MSW server to mock API requests
const server = setupServer(
  http.post('http://localhost:8080/api/v1/calculate', async ({ request }) => {
    const body = await request.json();
    
    if (body.expression === '2 + 2 * 5') {
      return HttpResponse.json({ result: 12 });
    }
    if (body.expression === '(10 + 5) / 3') {
      return HttpResponse.json({ result: 5 });
    }
    if (body.expression === '2 + * 3') {
      return new HttpResponse(null, {
        status: 400,
        statusText: 'Bad Request',
      });
    }
    return HttpResponse.json({ result: 0 });
  })
);

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

describe('Math Evaluator App', () => {
  it('should render the title and input field', () => {
    render(<App />);
    expect(screen.getByText(/Math Evaluator/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/2 \+ 2 \* 5/i)).toBeInTheDocument();
  });

  it('should calculate and display the result successfully', async () => {
    render(<App />);
    const input = screen.getByPlaceholderText(/2 \+ 2 \* 5/i);
    const button = screen.getByText('=');

    fireEvent.change(input, { target: { value: '2 + 2 * 5' } });
    fireEvent.click(button);

    await waitFor(() => {
      expect(screen.getByText('12')).toBeInTheDocument();
    });
  });

  it('should display an error message for invalid expressions', async () => {
    render(<App />);
    const input = screen.getByPlaceholderText(/2 \+ 2 \* 5/i);
    const button = screen.getByText('=');

    fireEvent.change(input, { target: { value: '2 + * 3' } });
    fireEvent.click(button);

    await waitFor(() => {
      expect(screen.getByText(/Error/i)).toBeInTheDocument();
    });
  });

  it('should show a placeholder "?" when no result is present', () => {
    render(<App />);
    expect(screen.getByText('?')).toBeInTheDocument();
  });
});
